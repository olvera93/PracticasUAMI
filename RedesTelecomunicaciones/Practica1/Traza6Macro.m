load data6.dat 
plot(data6(:,1), data6(:,2))
xlabel('Tiempo de sesi�n[s]')
ylabel('Retardo de extremo a extremo[s]')
title("Traza 6.- Retardo de extremo a extremo\n VoIP(Voice over IP)[Macrosc�pica]")
print -dpng "Traza6Macro.png"