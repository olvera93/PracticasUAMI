load data3.dat 
plot(data3(:,1), data3(:,2))
xlabel('Tiempo de sesi�n[s]')
ylabel('Retardo de extremo a extremo[s]')
title("Traza 3.- Retardo de extremo a extremo\n VoIP(Voice over IP)[Macrosc�pica]")
print -dpng "Traza3Macro.png"