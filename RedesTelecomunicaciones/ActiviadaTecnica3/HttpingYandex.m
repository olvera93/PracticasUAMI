load yandex_full.dat
plot(yandex_full, '--*g')
grid on
title('RTT con httping[Rusia]')
xlabel('Vuelta de Transmisi�n')
ylabel('RTT[round-trip time]')
print -dpng "Yandex.png"