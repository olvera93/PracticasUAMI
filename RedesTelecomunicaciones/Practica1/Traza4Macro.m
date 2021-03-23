load data4.dat 
plot(data4(:,1), data4(:,2))
xlabel('Tiempo de sesión[s]')
ylabel('Retardo de extremo a extremo[s]')
title("Traza 4.- Retardo de extremo a extremo\n VoIP(Voice over IP)[Macroscópica]")
print -dpng "Traza4Macro.png"