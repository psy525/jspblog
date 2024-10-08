/**
 * 
 */
window.addEventListener("load",start)

function start(){
    
/* ===========================
    Elements Selectors
============================ */

  const elm = {
    arrow: document.querySelector(".form-container__arrow"),
    overlay: document.querySelector(".overlay"),
    title: document.querySelector(".title"),
    signUpButton: document.querySelector(".buttons__signup"),
    loginButton: document.querySelector(".buttons__signup--login"),
    loginForm: document.querySelector(".login-form"),
    registerForm: document.querySelector(".login-form--register")
  }
  
/* ===========================
    Properties Object
============================ */

  const props = {
    left: "left: 20px;",
    bottom: "bottom: -500px;",
    transition1: "transition: bottom 1s;",
    transition2: "transition: bottom 2s;",
    opacity0: "opacity: 0;",
    opacity1: "opacity: 1;",
    trnsDelay: "transition-delay: 1s;",
    zIndex: "z-index: 6;",
    left0: "left: 0;",
    trnsDelay0: "transition-delay: 0s;",
    zIndex0: "z-index: 0;",
    leftM120: "left: -120px;"
  }
  
/* ===========================
    Elements Array
============================ */

  const elms = [elm.arrow, elm.overlay, elm.title, elm.signUpButton, elm.loginButton, elm.loginForm, elm.registerForm]
  
  function transition (elements, props){
    for (let i = 0; i < elements.length; i++){
      elements[i].setAttribute("style", `${props[i]}`)
    }
  } 

/* ===========================
    Events
============================ */

  document.getElementById("signUp").onclick = function (){

    const properties = [props.left, props.opacity0, props.opacity0, `${props.transition1} ${props.bottom}`, `${props.transition2} ${props.bottom}`, props.opacity0, `${props.opacity1} ${props.trnsDelay} ${props.zIndex}`]
  
    transition(elms, properties)
	console.log("버튼 눌러짐")
  }

  document.getElementById("login").onclick = function (){

    const properties = [props.left, props.opacity0, props.opacity0, `${props.transition1} ${props.bottom}`, `${props.transition2} ${props.bottom}`, `${props.opacity1} ${props.trnsDelay} ${props.zIndex}`, props.opacity0]
  
    transition(elms, properties)
  }

  document.getElementById("arrowClick").onclick = function (){

    const properties = [props.leftM120, props.opacity1, props.opacity1, props.opacity1, props.opacity1, `${props.opacity0} ${props.trnsDelay0} ${props.zIndex0}`, `${props.opacity0} ${props.trnsDelay0} ${props.zIndex0}`]
  
    transition(elms, properties)
  }
} 