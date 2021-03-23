load data3.dat 
stem(data3(:,1), data3(:,2))
axis([0, 15, 0, 0.8])
xlabel('Tiempo de sesión[s]')
ylabel('Retardo de extremo a extremo[s]')
title("Traza 3.- Retardo de extremo a extremo\n VoIP(Voice over IP)[Microscópica]")
print -dpng "Traza3Micro.png"