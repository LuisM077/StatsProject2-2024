% Tutorial Link: https://www.mathworks.com/help/matlab/learn_matlab/array-indexing.html
a = 1;
b = 2;

c = a + b;

d = cos(a);

sin(a);

e = a*b;

%matrices and arrays

a = [1 2 3 4]; %creates a row vector

a = [1 3 5; 2 4 6; 7 8 10]; %creates a matrix

a = [ 1 3 5
      2 4 6
      7 8 10]; %creates a matrix

z = zeros(5,1); %creates a 5x1 0 vector

a + 10; %matrix addition with a constant

sin(a); %sine of matrix a
a'; %traspose of the matrix

p = a*inv(a); %matrix times its inverse

format long %for floating points
p = a*inv(a);

format short
p = a .* a;

a .^ 3;

%concatenation
A = [a,a];

A = [a; a]; %vertically

%complex numbers
sqrt(-1);

c = [3+4i, 4+3j; -i, 10j];


% Array Indexing

A = [1 2 3 4; 5 6 7 8; 9 10 11 12; 13 14 15 16];

A(4,2);
A(8); %traverese through each column in order

A(4,5) = 17;

A(1:3, 2);

A(3, :);

B = 0:10:100;

A = magic(4);
B = rand(3,5,2);

% Text and Characters

t = "Hello World";
q = "Something ""quoted"" and something else.";

f = 71;
c = (f-32)/1.8;
temtText6 = "Temperature is " + c + "C";

A = ["a","bb","ccc"; "dddd","eeeeee","fffffff"]; %2x3 array using characters

seq = 'GCTAGAATCC';
seq(4);

seq2 = [seq 'ATTAGAAACC'];


%Calling Functions
A = [ 1 3 5];
max(A);

B = [ 3 6 9];
union(A,B);

maxA = max(A);

[minA,maxA] = bounds(A);

%disp("hello world")


%2D and 3D Plots

%{
x = linspace(0,2*pi);
y = sin(x);
plot(x,y)
xlabel("x")
ylabel("sin(x)")
title("Plot of the Sine Function")
plot(x,y, "r--")
%}

%{
x = linspace(0,2*pi);
y = sin(x);
plot(x,y)
hold on 
y2 = cos(x);
plot(x,y2,":")
legend("sin", "cos")
hold off 
%}


%3D plots

%{
x = linspace(-2,2,20);
y = x';
z = x .* exp(-x .^ 2 - y .^ 2);

surf(x,y,z)
%}

%{
%Multiple Plots
t = tiledlayout(2,2);
title(t,"Trigonometric Functions")
x = linspace(0,30);

nexttile
plot(x,sin(x))
title("Sine")

nexttile
plot(x,cos(x))
title("Cosine")

nexttile
plot(x,tan(x))
title("Tangent")

nexttile
plot(x,sec(x))
title("Secant")
%}

%programming and scripts

%{
edit mysphere

[x,y,z] = sphere; 
r = 2;
surf(x*r,y*r,z*r)
axis equal

A = 4*pi*r^2;
V = (4/3)*pi*r^3;

% Create and plot a sphere with radius r.
[x,y,z] = sphere;       % Create a unit sphere.
r = 2;
surf(x*r,y*r,z*r)       % Adjust each dimension and plot.
axis equal              % Use the same scale for each axis. 
 
% Find the surface area and volume.
A = 4*pi*r^2;
V = (4/3)*pi*r^3;

mysphere

edit newfile.mlx
%}

%Loops and Conditional Statements
N = 100;
f(1) = 1;
f(2) = 1;

for n = 3:N
    f(n) = f(n-1) + f(n-2);
end
f(1:10)


num = randi(100)
if num < 34
   sz = 'low'
elseif num < 67
   sz = 'medium'
else
   sz = 'high'
end