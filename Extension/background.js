//<Refernce Link: https://medium.com/swlh/create-a-email-password-login-system-for-your-chrome-extension-c36cff6d5e40>
let user_signed_in = false;
let return_session = false;

function is_user_signed_in() {
    return new Promise(resolve => {
        chrome.storage.local.get(['userStatus', 'user_info'],
            function (response) {
                if (chrome.runtime.lastError) resolve({ userStatus: 
                    false, user_info: {} })
            resolve(response.userStatus === undefined ?
                    { userStatus: false, user_info: {} } :
                    { userStatus: response.userStatus, user_info: 
                    response.user_info }
                    )
            });
    });
}

function flip_user_status(signIn, user_info) {
    if (signIn) {
        console.log(user_info.email)
        console.log(user_info.password)
        return fetch('https://easy-apply-seng20.herokuapp.com/user/login', {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({"username": "user_info.email", 
                    "password": "user_info.password"})
        })
            .then(res => {
                return new Promise(resolve => {
                    if (res.status !== 200) resolve('fail')

                    chrome.storage.local.set({ userStatus: signIn, user_info }, function (response) {
                        if (chrome.runtime.lastError) resolve('fail');

                        user_signed_in = signIn;
                        resolve('success');
                    });
                })
            })
            .catch(err => console.log(err));
    } else if (!signIn) {
        // https://easy-apply-seng20.herokuapp.com/user/login
        return new Promise(resolve => {
            chrome.storage.local.get(['userStatus', 'user_info'], function (response) {
                console.log(response);
                if (chrome.runtime.lastError) resolve('fail');
    
                if (response.userStatus === undefined) resolve('fail');
                console.log("hi")
                fetch('https://easy-apply-seng20.herokuapp.com/user/login', {
                    method: 'POST',
                    headers: {'Content-Type': 'application/json'},
                    body: JSON.stringify({"username": "user_info.email", 
                            "password": "user_info.password"})
                })
                    .then(res => {
                        console.log(res);
                        if (res.status !== 200) resolve('fail');
    
                        chrome.storage.local.set({ userStatus: signIn, user_info: {} }, function (response) {
                            if (chrome.runtime.lastError) resolve('fail');
    
                            user_signed_in = signIn;
                            resolve('success');
                        });
                    })
                    .catch(err => console.log(err));
            });
        });
    }
}
    
is_user_signed_in().then(res => {
    if(res.userStatus) return_session = true;
    user_signed_in = res.userStatus;
})
.catch(err => console.log(res));
    
chrome.browserAction.onClicked.addListener(function () {
        is_user_signed_in()
            .then(res => {
                if (res.userStatus) {
                    if (return_session) {
                        chrome.browserAction.setPopup({popup: "/popup-welcome-back.html"});
                    } else {
                        chrome.browserAction.setPopup({popup: "/popup-sign-out.html"});
                    }
                } else {
                    chrome.browserAction.setPopup({popup: "/popup-sign-in.html"});
                }
            })
            .catch(err => console.log(err));
    });
    
        chrome.runtime.onMessage.addListener((request, sender, sendResponse) => {
        if (request.message === 'login') {
            flip_user_status(true, request.payload)
                .then(res => sendResponse(res))
                .catch(err => console.log(err));
            return true;
        } else if (request.message === 'logout') {
            flip_user_status(false, null)
                .then(res => sendResponse(res))
                .catch(err => console.log(err));
            return true;
        }  else if (request.message === 'userStatus') {
            is_user_signed_in()
                .then(res => {
                    sendResponse({ 
                        message: 'success',
                        userStatus: res.userStatus, user_info: res.user_info.email
                    });
                })
                .catch(err => console.log(err));
                return true;
            }
    });
