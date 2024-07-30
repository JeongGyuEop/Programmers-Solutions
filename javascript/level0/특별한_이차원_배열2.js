// function solutions(arr) {
//   for (let i = 0; i < arr.length; i++) {
//     for (let j = 0; j < arr[i].length; j++) {
//       if (arr[i][j] !== arr[j][i]) {
//         return 0;
//       }
//     }
//   }
//   return 1;
// }

function solution(arr) {
  return arr.every((r, i) => r.every((_, j) => arr[i][j] === arr[j][i])) ? 1 : 0;
}

let array = [
  [5, 192, 33],
  [192, 72, 95],
  [33, 95, 999]
];
console.log(solutions(array));
