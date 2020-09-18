//<Refernce Link: https://medium.com/swlh/create-a-email-password-login-system-for-your-chrome-extension-c36cff6d5e40>
document.querySelector('form').addEventListener('submit', event => {
    event.preventDefault();

    const email = document.querySelector('#username').value;
    const pass = document.querySelector('#password').value;

    if (email && password) {
        chrome.runtime.sendMessage({ message: 'login', 
      payload: { email, pass }},
      function (response) {
          if (response === 'success')
              window.location.replace('./popup-sign-out.html');
  });
    } else {
        document.querySelector('#username').placeholder = "Enter a username.";
        document.querySelector('#password').placeholder = "Enter a password.";
        document.querySelector('#username').style.backgroundColor = 'red';
        document.querySelector('#password').style.backgroundColor = 'red';
        document.querySelector('#username').classList.add('white_placeholder');
        document.querySelector('#password').classList.add('white_placeholder');
    }
});
