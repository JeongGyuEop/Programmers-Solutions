function solution(arr, n) {
  var answer = [];
  if (arr.length % 2 === 1) {
    for (let i = 0; i < arr.length; i++) {
      if (i % 2 === 1) {
        answer.push(arr[i]);
      } else {
        answer.push(arr[i] + n);
      }
    }
  } else {
    for (let i = 0; i < arr.length; i++) {
      if (i % 2 === 0) {
        answer.push(arr[i]);
      } else {
        answer.push(arr[i] + n);
      }
    }
  }
  return answer;
}

// const solution = (arr, n) => arr.map((num, idx) => (
//   arr.length % 2 !== idx % 2
//   ? num + n
//   : num
// ));
