import matplotlib.pyplot as plt

y = [int(r.strip()) for r in open("digdelnums.txt", "r").readlines()]
x = [i for i in range(len(y))]
plt.plot(x, y, linewidth = 0.5)
#m:379285.0000000000
#b:2649952.738780207
otherX = [i for i in range(1738)]
otherY = [i*379285.0+2649952.738780207 for i in otherX]
plt.plot(otherX, otherY, linewidth = 0.5, color = "red")
plt.show()
