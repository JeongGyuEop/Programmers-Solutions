const solution = (arr, target) => {
  arr = arr.filter(item => !item.includes(target)).join('');
  return arr;
};
