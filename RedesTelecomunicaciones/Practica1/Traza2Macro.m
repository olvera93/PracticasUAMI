load data2.dat 
plot(data2(:,1), data2(:,2))
xlabel('Tiempo de sesión[s]')
ylabel('Retardo de extremo a extremo[s]')
title("Traza 2.- Retardo de extremo a extremo\n VoIP(Voice over IP)[Macroscópica]")
print -dpng "Traza2Macro.png"