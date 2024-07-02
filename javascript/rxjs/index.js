import { Observable } from 'rxjs-es'

var button = document.querySelector("button");
// button.addEventListener('click', (event) => {
//     console.log(event)
// })

Observable.fromEvent(button, 'click').subscribe((event) => {
    console.log(event)
});
