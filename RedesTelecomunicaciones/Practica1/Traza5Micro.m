load data5.dat 
stem(data5(:,1), data5(:,2))
axis([0, 15])
xlabel('Tiempo de sesión[s]')
ylabel('Retardo de extremo a extremo[s]')
title("Traza 5.- Retardo de extremo a extremo\n VoIP(Voice over IP)[Microscópica]")
print -dpng "Traza5Micro.png"
print -deps "1.eps"