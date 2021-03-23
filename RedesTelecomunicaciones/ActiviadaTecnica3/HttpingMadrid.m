load uames_full.dat
plot(uames_full, '--*m')
grid on
title('RTT con httping[España]')
xlabel('Vuelta de Transmisión')
ylabel('RTT[round-trip time]')
print -dpng "UAMes.png"