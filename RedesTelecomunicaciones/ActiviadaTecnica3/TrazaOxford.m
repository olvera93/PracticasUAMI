load oxford_full.dat
plot(oxford_full, '--*r')
grid on
title('Retardo de ida y vuelta[Londres]')
xlabel('Vuelta de Transmisión')
ylabel('RTT[round-trip time]')
print -deps "Oxford.eps"
print -dpng "Oxford.png"