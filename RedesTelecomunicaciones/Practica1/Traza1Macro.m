load data1.dat 
plot(data1(:,1), data1(:,2))
xlabel('Tiempo de sesión[s]')
ylabel('Retardo de extremo a extremo[s]')
title("Traza 1.- Retardo de extremo a extremo\n VoIP(Voice over IP)[Macroscópica]")
print -dpng "Traza1Macro.png"

