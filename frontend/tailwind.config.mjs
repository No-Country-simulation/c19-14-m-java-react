/** @type {import('tailwindcss').Config} */
export default {
    content: ['./src/**/*.{astro,html,js,jsx,md,mdx,svelte,ts,tsx,vue}'],
    theme: {
        extend: {
            colors: {
                primary: '#E3D6F5',
                secondary: '#8F5BD7',
                tertiary: '#0A453A',
                accent: '#F5E1DA',
                dark: '#1A202C',
            },
        },
    },
    plugins: [],
}
