const solution = arr => {
  return arr.reduce((acc, idx) => {
    const value = parseInt(idx.includes('latte') ? 5000 : 4000);
    return acc + value;
  }, 0);
};
