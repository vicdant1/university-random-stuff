
function changeImage() {
  const references = ["./chara-1.png", "./chara-2.png", "./chara-3.png"];
  
  let  sprite = document.querySelector(".sprite");
  let mod = 0;
  setInterval(() => {
    mod = (mod + 1) % references.length;
    sprite.src = references[mod];
  }, 500);
}

changeImage()