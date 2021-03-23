load data1.dat 
stem(data1(:,1), data1(:,2))
axis([0, 15])
xlabel('Tiempo de sesión[s]')
ylabel('Retardo de extremo a extremo[s]')
title("Traza 1.- Retardo de extremo a extremo\n VoIP(Voice over IP)[Microscópica]")
print -dpng "Traza1Micro.png"

save -dpng "Prueba.png"


