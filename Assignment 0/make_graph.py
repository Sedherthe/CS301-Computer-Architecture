import matplotlib
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
import csv
x = []
y = []
z = []

with open('filename4.txt', 'r') as csvfile:
	plots = csv.reader(csvfile, delimiter=',')
	for row in plots:
		x.append(int(row[0]))
		y.append(float(row[1]))
		z.append(int(row[2]))

fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')
print(y)
plt.title("Width vs Probability vs Average time")
ax.scatter(x, y, z, zdir='z')
ax.set_xlabel("Width")
ax.set_ylabel("Probability")
ax.set_zlabel("Time")

plt.show()