load data1.dat 
plot(data1(:,1), data1(:,2))
xlabel('Tiempo de sesi�n[s]')
ylabel('Retardo de extremo a extremo[s]')
title("Traza 1.- Retardo de extremo a extremo\n VoIP(Voice over IP)[Macrosc�pica]")
print -dpng "Traza1Macro.png"

