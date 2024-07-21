const solution = (target1, target2) => {
  if (target1 % 2 !== 0 && target2 % 2 !== 0) {
    return Math.pow(target1, 2) + Math.pow(target2, 2);
  } else if (target1 % 2 !== 0 || target2 % 2 !== 0) {
    return 2 * (target1 + target2);
  } else {
    return Math.abs(target1 - target2);
  }
};
