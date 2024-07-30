const solution = (arr, k) => {
  return k % 2 === 0 ? arr.map(element => element + k) : arr.map(element => element * k);
};
