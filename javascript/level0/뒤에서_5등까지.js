// function solution(num_list) {
//   var answer = [];

//   return answer;
// }

const solution = arr => {
  arr.sort((a, b) => a - b);
  return arr.slice(0, 5);
};
