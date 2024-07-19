const solution = (arr1, arr2) => {
  const partition = arr1.map((rank, idx) => ({ rank, idx })).filter((_, idx) => arr2[idx]);

  partition.sort((a, b) => a.rank - b.rank);

  const [a, b, c] = partition.slice(0, 3).map(participant => participant.idx);

  return 10000 * a + 100 * b + c;
};

// 매핑
// arr1.map((rank, idx) => ({ rank, idx })):
// arr1 배열의 각 요소와 인덱스를 { rank, idx } 형식의 객체로 매핑합니다.
// 예를 들어, arr1이 [3, 1, 4, 2]인 경우,
// 결과는 [{ rank: 3, idx: 0 }, { rank: 1, idx: 1 },
//           { rank: 4, idx: 2 }, { rank: 2, idx: 3 }]가 됩니다.

// 필터링
//.filter((_, idx) => arr2[idx]):
// arr2 배열에서 true 값인 인덱스를 기준으로 필터링합니다.
// 예를 들어, arr2가 [true, false, true, true]인 경우,
//    결과는 [{ rank: 3, idx: 0 }, { rank: 4, idx: 2 }, { rank: 2, idx: 3 }]가 됩니다.

// 정렬
// partition.sort((a, b) => a.rank - b.rank):
// 필터링된 객체 배열을 rank 값에 따라 오름차순으로 정렬합니다.
// 정렬된 결과는 [{ rank: 2, idx: 3 }, { rank: 3, idx: 0 }, { rank: 4, idx: 2 }]가 됩니다.

// 추출:
// partition.slice(0, 3).map(participant => participant.idx):
// 정렬된 배열에서 상위 3명의 객체를 추출하고, 각 객체의 idx 값을 배열로 반환합니다.
// 예를 들어, 상위 3명의 idx 값은 [3, 0, 2]가 됩니다.
v;
