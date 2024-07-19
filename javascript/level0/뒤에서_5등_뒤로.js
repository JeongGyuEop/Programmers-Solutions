const solution = arr => {
  arr.sort((a, b) => a - b);
  return arr.slice(5, arr.length);
};
