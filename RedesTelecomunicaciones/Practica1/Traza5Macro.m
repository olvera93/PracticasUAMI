load data5.dat 
plot(data5(:,1), data5(:,2))
xlabel('Tiempo de sesi�n[s]')
ylabel('Retardo de extremo a extremo[s]')
title("Traza 5.- Retardo de extremo a extremo\n VoIP(Voice over IP)[Macrosc�pica]")
print -dpng "Traza5Macro.png"