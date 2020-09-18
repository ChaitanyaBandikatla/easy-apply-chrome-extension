//<Refernce Link: https://medium.com/swlh/create-a-email-password-login-system-for-your-chrome-extension-c36cff6d5e40>
const button = document.querySelector('button');

button.addEventListener('click', () => {
    chrome.runtime.sendMessage({ message: 'logout' },
    function (response) {
        if (response === 'success')
            window.location.replace('./popup-sign-in.html');
});
});
