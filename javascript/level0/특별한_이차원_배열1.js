const solution = tmp1 => {
  let arr = new Array(tmp1);
  for (let i = 0; i < tmp1; i++) {
    arr[i] = new Array(tmp1).fill(0);
    arr[i][i] = 1;
  }
  return arr;
};

let tmp1 = 3;

console.log(solution(tmp1));

// function solution(n) {
//   const answer = Array.from(Array(n), () => Array(n).fill(0));

//   for (let i = 0; i < n; i++) {
//     answer[i][i] = 1;
//   }

//   return answer;
// }
