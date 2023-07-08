const pwShowHide = document.querySelectorAll(".pw_hide");
// const formContainer = document.querySelector('.form_container');

if (pwShowHide) {
  pwShowHide.forEach((icon) => {
    icon.addEventListener("click", () => {
      let getPwInput = icon.parentElement.querySelector("input");
      if (getPwInput.type === "password") {
        getPwInput.type = "text";
        icon.classList.replace("uil-eye-slash", "uil-eye");
      } else {
        getPwInput.type = "password";
        icon.classList.replace("uil-eye", "uil-eye-slash");
      }
    });
  });
}


  const searchButton = document.querySelector('.search_button');
  const searchBar = document.querySelector('.search_bar');
  const searchClose = document.querySelector('.search_close');

  searchButton.addEventListener('click', function () {
    searchBar.style.display = 'flex';
  });

  searchClose.addEventListener('click', function () {
    searchBar.style.display = 'none';
  });