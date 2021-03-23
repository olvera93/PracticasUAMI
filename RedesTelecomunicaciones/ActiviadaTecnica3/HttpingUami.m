load uami_full.dat
plot(uami_full, '--*c')
grid on
title('RTT con httping[México]')
xlabel('Vuelta de Transmisión')
ylabel('RTT[round-trip time]')
print -dpng "UAMI.png"