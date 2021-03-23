load data6.dat 
stem(data6(:,1), data6(:,2))
axis([0, 15, 0, 1])
xlabel('Tiempo de sesión[s]')
ylabel('Retardo de extremo a extremo[s]')
title("Traza 6.- Retardo de extremo a extremo\n VoIP(Voice over IP)[Microscópica]")
print -dpng "Traza6Micro.png"