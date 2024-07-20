const solution = (arr1, arr2) => {
  arr1 = arr1.filter(arr1 => !arr2.includes(arr1));
  return arr1;
};
