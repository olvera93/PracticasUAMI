load uami_full.dat
plot(uami_full, '--*c')
grid on
title('RTT con httping[M�xico]')
xlabel('Vuelta de Transmisi�n')
ylabel('RTT[round-trip time]')
print -dpng "UAMI.png"