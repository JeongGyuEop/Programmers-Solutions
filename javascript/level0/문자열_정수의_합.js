const solution = str => {
  let result = Array.from(str);
  let sum = result.reduce((acc, curr) => acc + Number(curr), 0);
  return sum;
};
