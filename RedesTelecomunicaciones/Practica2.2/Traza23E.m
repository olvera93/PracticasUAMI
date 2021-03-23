load h23.dat
load hop23.txt
hold on
sampleRTT = hop23
estimatedRTT = h23(:,1)
timeout = h23(:,2)
plot(sampleRTT, '-d', 'linewidth', 1) 
plot(estimatedRTT, '-s', 'linewidth', 1) 
plot(timeout, '-*k', 'linewidth', 1)
axis([130, 160, 0, 600])
xlabel("Número de vueltas")
ylabel("RTT[ms]")
title("Valor de α = 0.125 y  β = 0.25 con un error cuadrático medio = 144.5998")
subtitle("Traza 23 -- SET E")
MSE = mean((sampleRTT - estimatedRTT).^2);
legend({'sampleRTT', 'EstimatedRTT', 'TimeoutInterval'}, 'location', "northwestoutside")
grid on 