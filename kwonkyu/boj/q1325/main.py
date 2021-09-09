import collections
import sys

input = sys.stdin.readline


N, M = input().split()
N, M = int(N), int(M)

trust = collections.defaultdict(list)
score = [0] * (N + 1)

while M > 0:
    M -= 1
    trusting, trusted = input().split()
    trust[int(trusted)].append(int(trusting))

queue = collections.deque()

for computer in range(1, N+1):
    queue.clear()
    queue.append(computer)
    hacked = [False] * (N + 1)

    while queue:
        connected = queue.popleft()
        hacked[connected] = True
        queue.extend([x for x in trust[connected] if hacked[x] is False])
        score[computer] += 1

score = score[1:]
maxScore = max(score)
for index, score in enumerate(score):
    if score == maxScore:
        print(index + 1, end=" ")
