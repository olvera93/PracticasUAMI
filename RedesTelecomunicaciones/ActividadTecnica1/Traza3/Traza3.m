load hop03.txt
plot(hop03)
axis([0, 5000, 0, 8])   #Es una función que fija el rango de los ejes de las x's y y's
xlabel('Retardo de vuelta')
ylabel('Retardo de ida y vuelta')
print('Traza3.png', '-dpng')
#print('Traza3.eps', '-depsc')