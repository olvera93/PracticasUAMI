load baidu_full.dat
plot(baidu_full, '--*')
grid on
title('Retardo de ida y vuelta[China]')
xlabel('Vuelta de Transmisión')
ylabel('RTT[round-trip time]')
print -deps "Baidu.eps"
print -dpng "Baidu.png"