import React from 'react'

export default function Login() {

  const onOauthButtonClickHandler = (provider: string) => {
    window.location.href = `http://localhost:4040/api/v1/auth/social/${provider}`;

  }

  return (
    <div>
      <button onClick={() => onOauthButtonClickHandler('github')}>Github Login</button>
    </div>
  )
}
