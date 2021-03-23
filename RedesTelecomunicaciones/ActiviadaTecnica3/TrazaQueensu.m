load queensu_full.dat
plot(queensu_full, '--*','Color' ,[0.8500 0.3250 0.0980])
grid on
title('Retardo de ida y vuelta[Canadá]')
xlabel('Vuelta de Transmisión')
ylabel('RTT[round-trip time]')
print -deps "Queensu.eps"
print -dpng "Queensu.png"