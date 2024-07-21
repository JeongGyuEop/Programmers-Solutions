function solution(picture, k) {
  return picture.flatMap(row => {
    // 각 문자를 k배로 반복하여 문자열 생성
    const enlargedRow = row
      .split('')
      .map(char => char.repeat(k))
      .join('');
    // 생성된 문자열을 k번 반복하여 배열로 반환
    return Array(k).fill(enlargedRow);
  });
}
