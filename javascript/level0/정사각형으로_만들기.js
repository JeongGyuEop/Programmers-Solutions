function solution(arr) {
  for(let i = 0; i < arr.length; i++) { 
    for(let j = 0; j < arr[i].length; j++) {
      arr.length > arr[i].length ? arr[i].push(0);
    }
  }
}

let arr = [
  [572, 22, 37],
  [287, 726, 384],
  [85, 137, 292],
  [487, 13, 876]
];

console.log(solution(arr));
