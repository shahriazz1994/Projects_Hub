from django.shortcuts import render, redirect
from django.contrib import messages  # displays flash messages
from .forms import UserRegisterForm, UserUpdateForm, ProfileUpdateForm
from django.contrib.auth.decorators import login_required


def register(request):
    if request.method == 'POST':
        form = UserRegisterForm(request.POST)
        if form.is_valid():
            form.save()
            username = form.cleaned_data.get('username')
            messages.success(request, f'{username} Account has been created Now log in.!')
            return redirect('login')
    else:
        form = UserRegisterForm()
    return render(request, 'accounts/register.html', {'form': form})


@login_required
def profile(request):
    if request.method == 'POST':
        form_user = UserUpdateForm(request.POST, instance=request.user)
        form_profile = ProfileUpdateForm(request.POST, request.FILES, instance=request.user.profile)

        if form_user.is_valid() and form_profile.is_valid():
            form_user.save()
            form_profile.save()
            messages.success(request, f'Profile updated successfully.')

    else:
        form_user = UserUpdateForm(instance=request.user)
        form_profile = ProfileUpdateForm(instance=request.user.profile)

    return render(request, 'accounts/profile.html', context={'form_user': form_user, 'form_profile': form_profile})
