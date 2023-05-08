const showResults = () => {
  let totalPoints = 0;

  let firstQuestionAnswer = document.querySelector("[name='question1']");
  let secondQuestionAnswer = document.querySelector("[name='question2']");
  let thirdQuestionAnswer = document.querySelector("[name='question3']");
  let fourthQuestionAnswer = document.querySelector("[name='question4']");

  if (firstQuestionAnswer.checked) totalPoints += 5;

  if (secondQuestionAnswer.checked) totalPoints += 5;

  if (thirdQuestionAnswer.checked) totalPoints += 5;

  if (fourthQuestionAnswer.checked) totalPoints += 5;

  switch (totalPoints) {
    case 0:
      alert("Credo, não acertou nada!");
      break;
    case 5:
      alert("Hehe, pelo menos uma!");
      break;
    case 10:
      alert("Ta aprovado com média 5!");
      break;
    case 15:
      alert("Na trave");
      break;
    case 20:
      alert("Esse cara é bom mesmo!");
      break;
  }
};
