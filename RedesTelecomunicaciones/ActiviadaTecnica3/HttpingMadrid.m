load uames_full.dat
plot(uames_full, '--*m')
grid on
title('RTT con httping[Espa�a]')
xlabel('Vuelta de Transmisi�n')
ylabel('RTT[round-trip time]')
print -dpng "UAMes.png"