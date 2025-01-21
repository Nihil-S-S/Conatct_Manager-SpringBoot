// import theme from "tailwindcss/defaultTheme.js";

console.log("script loaded");

let currentTheme = getTheme();

console.log(currentTheme);


document.addEventListener("DOMContentLoaded", () => {
    changeTheme();
})

function changeTheme() {
    changePageTheme(currentTheme, currentTheme);
    const changeThemeButton = document.querySelector("#theme_change_button");
    const oldtheme = currentTheme;
    changeThemeButton.addEventListener("click"  , () => {
        console.log("clicked");
        currentTheme = currentTheme === "light" ? "dark" : "light";
        changePageTheme(currentTheme, oldtheme);
    });
}

function changePageTheme(theme, oldtheme) {

    setTheme(currentTheme);

    document.querySelector("html").classList.remove(oldtheme);

    document.querySelector("html").classList.add(theme);

    document.querySelector("#theme_change_button").querySelector("span").textContent = theme === "light" ? "dark" : "light";
}

function setTheme(theme) {
    localStorage.setItem("theme", theme);
}

function getTheme() {
    let theme = localStorage.getItem("theme");
    return theme? theme : "light";
}
