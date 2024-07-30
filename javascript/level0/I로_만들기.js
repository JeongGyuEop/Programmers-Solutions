const solution = (str, replaceChar = 'l') => {
  return str
    .split('')
    .map(element => (element < 'l' ? replaceChar : element))
    .join('');
};

let target1 = 'abcdevwxyz';
console.log(solution(target1));
