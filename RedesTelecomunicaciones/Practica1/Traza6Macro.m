load data6.dat 
plot(data6(:,1), data6(:,2))
xlabel('Tiempo de sesión[s]')
ylabel('Retardo de extremo a extremo[s]')
title("Traza 6.- Retardo de extremo a extremo\n VoIP(Voice over IP)[Macroscópica]")
print -dpng "Traza6Macro.png"