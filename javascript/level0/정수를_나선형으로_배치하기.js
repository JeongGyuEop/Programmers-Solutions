const solution = num => {
  const arr = Array.from(Array(num), () => Array(num).fill(0));
  let val = 1;
  let top = 0,
    bottom = num - 1,
    left = 0,
    right = num - 1;
  while (val <= num * num) {
    for (let i = left; i <= right; i++) {
      arr[top][i] = val++;
    }
    top++;

    for (let i = top; i <= bottom; i++) {
      arr[i][right] = val++;
    }
    right--;

    for (let i = right; i >= left; i--) {
      arr[bottom][i] = val++;
    }
    bottom--;

    for (let i = bottom; i >= top; i--) {
      arr[i][left] = val++;
    }
    left++;
  }
  return arr;
};

let num = 4;
console.log(solution(num));
