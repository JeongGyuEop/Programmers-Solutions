const solution = (str) => {
  let arr = Array.from(str);
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] !== "0") {
      arr = arr.slice(i, arr.length);
      break;
    }
  }
  return arr.join("");
};

// const solution = (str) => String(Number(str))
// 간단하게 해결할 수 있는 이러한 방법도 있다.
